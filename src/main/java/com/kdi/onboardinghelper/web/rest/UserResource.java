package com.kdi.onboardinghelper.web.rest;

import com.kdi.onboardinghelper.config.Constants;
import com.kdi.onboardinghelper.domain.PersonalDetails;
import com.kdi.onboardinghelper.domain.User;
import com.kdi.onboardinghelper.repository.UserRepository;
import com.kdi.onboardinghelper.security.AuthoritiesConstants;
import com.kdi.onboardinghelper.service.MailService;
import com.kdi.onboardinghelper.service.UserService;
import com.kdi.onboardinghelper.service.dto.UserDTO;
import com.kdi.onboardinghelper.web.rest.errors.BadRequestAlertException;
import com.kdi.onboardinghelper.web.rest.errors.EmailAlreadyUsedException;
import com.kdi.onboardinghelper.web.rest.errors.LoginAlreadyUsedException;
import java.io.FileNotFoundException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;

/**
 * REST controller for managing users.
 * <p>
 * This class accesses the {@link User} entity, and needs to fetch its
 * collection of authorities.
 * <p>
 * For a normal use-case, it would be better to have an eager relationship
 * between User and Authority, and send everything to the client side: there
 * would be no View Model and DTO, a lot less code, and an outer-join which
 * would be good for performance.
 * <p>
 * We use a View Model and a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities,
 * because people will quite often do relationships with the user, and we don't
 * want them to get the authorities all the time for nothing (for performance
 * reasons). This is the #1 goal: we should not impact our users' application
 * because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is
 * not a real issue as we have by default a second-level cache. This means on
 * the first HTTP call we do the n+1 requests, but then all authorities come
 * from the cache, so in fact it's much better than doing an outer join (which
 * will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages users, for security reasons, we'd rather have a DTO
 * layer.</li>
 * </ul>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this
 * case.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserService userService;

    private final UserRepository userRepository;

    private final MailService mailService;

    public UserResource(UserService userService, UserRepository userRepository, MailService mailService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    /**
     * {@code POST  /users} : Creates a new user.
     * <p>
     * Creates a new user if the login and email are not already used, and sends
     * an mail with an activation link. The user needs to be activated on
     * creation.
     *
     * @param userDTO the user to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and
     * with body the new user, or with status {@code 400 (Bad Request)} if the
     * login or email is already in use.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     * @throws BadRequestAlertException {@code 400 (Bad Request)} if the login
     * or email is already in use.
     */
    @PostMapping("/users")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);

        if (userDTO.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", "userManagement", "idexists");
            // Lowercase the user login before comparing with database
        } else if (userRepository.findOneByLogin(userDTO.getLogin().toLowerCase()).isPresent()) {
            throw new LoginAlreadyUsedException();
        } else if (userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
        } else {
            User newUser = userService.createUser(userDTO);
            mailService.sendCreationEmail(newUser);
            return ResponseEntity.created(new URI("/api/users/" + newUser.getLogin()))
                    .headers(HeaderUtil.createAlert(applicationName, "A user is created with identifier " + newUser.getLogin(), newUser.getLogin()))
                    .body(newUser);
        }
    }

    /**
     * {@code PUT /users} : Updates an existing User.
     *
     * @param userDTO the user to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the updated user.
     * @throws EmailAlreadyUsedException {@code 400 (Bad Request)} if the email
     * is already in use.
     * @throws LoginAlreadyUsedException {@code 400 (Bad Request)} if the login
     * is already in use.
     */
    @PutMapping("/users")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
        log.debug("REST request to update User : {}", userDTO);
        Optional<User> existingUser = userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(userDTO.getId()))) {
            throw new EmailAlreadyUsedException();
        }
        existingUser = userRepository.findOneByLogin(userDTO.getLogin().toLowerCase());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(userDTO.getId()))) {
            throw new LoginAlreadyUsedException();
        }
        Optional<UserDTO> updatedUser = userService.updateUser(userDTO);

        return ResponseUtil.wrapOrNotFound(updatedUser,
                HeaderUtil.createAlert(applicationName, "A user is updated with identifier " + userDTO.getLogin(), userDTO.getLogin()));
    }

    @PostMapping("/insertUserPersonalDetail")
    public ResponseEntity<PersonalDetails> updateUser(@Valid @RequestBody PersonalDetails userDTO) {
        log.debug("REST request to update User : {}", userDTO);
        PersonalDetails existingUser;
        existingUser = userService.saveDetails(userDTO);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }

    /**
     * {@code GET /users} : get all users.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body all users.
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(Pageable pageable) {
        final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * Gets a list of all roles.
     *
     * @return a string list of all roles.
     */
    @GetMapping("/users/authorities")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public List<String> getAuthorities() {
        return userService.getAuthorities();
    }

    @GetMapping("/getPersonDetailsByUserName")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public void getUserDetails(@RequestParam String email) {
        System.out.println("com.kdi.onboardinghelper.web.rest.UserResource.getUserDetails()" + email);
    }

     @RequestMapping(value = "/users/getPdf", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<byte[]> hello() throws IOException
    {


	FileInputStream fileStream;
	File file = getFile();

	try
	{
	    fileStream = new FileInputStream(file);
	    byte contents[] = new byte[(int) file.length()];
	    fileStream.read(contents);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "123.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	    return response;
	}
	catch (FileNotFoundException e)
	{
	    System.err.println(e);
	}
	catch (IOException e)
	{
	    System.err.println(e);
	}
	return null;

	// return "/123.pdf";
    }

    public File getFile() throws IOException{
          PDDocument doc = PDDocument.load(new File("C:/Users/barank/Desktop/joining-docs/sample.pdf"));

        //Creating a PDF Document
        PDPage page = doc.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true);


        addTextInPDF(contentStream, "Baranitharan K", 75, 523);
        addTextInPDF(contentStream, "#47,10th Cross, Maruthi Nagar", 82, 497);
        addTextInPDF(contentStream, "Madiwala,Bangalore - 560068", 82, 484);
        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        File f = new File("C:/Users/barank/Desktop/joining-docs/test.pdf");
        doc.save(f);

        //Closing the document
        doc.close();
        return f;
    }

    public static void addTextInPDF(PDPageContentStream contentStream, String text, int x, int y) throws IOException {
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.newLineAtOffset(x, y);
        String text2 = text;

        //Adding text in the form of string
        contentStream.showText(text2);

        //Ending the content stream
        contentStream.endText();
    }
    /**
     * {@code GET /users/:login} : get the "login" user.
     *
     * @param login the login of the user to find.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with
     * body the "login" user, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String login) {
        log.debug("REST request to get User : {}", login);
        return ResponseUtil.wrapOrNotFound(
                userService.getUserWithAuthoritiesByLogin(login)
                        .map(UserDTO::new));
    }

    /**
     * {@code DELETE /users/:login} : delete the "login" User.
     *
     * @param login the login of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/users/{login:" + Constants.LOGIN_REGEX + "}")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<Void> deleteUser(@PathVariable String login) {
        log.debug("REST request to delete User: {}", login);
        userService.deleteUser(login);
        return ResponseEntity.noContent().headers(HeaderUtil.createAlert(applicationName, "A user is deleted with identifier " + login, login)).build();
    }
}
