/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kdi.onboardinghelper.service.dto;

public class CompleteFormDTO {

    private Long employeeId;
    private BasicFormDTO basicForm;
    private FormFDTO formF;
    private FormIDTO formI;
    private FormQDTO formQ;
    private PersonalFormDTO personalForm;
    private ProvidentFundFormDTO providentFundForm;

    public CompleteFormDTO(Long employeeId, BasicFormDTO basicForm, FormFDTO formF, FormIDTO formI, FormQDTO formQ, PersonalFormDTO personalForm, ProvidentFundFormDTO providentFundForm) {
        this.employeeId = employeeId;
        this.basicForm = basicForm;
        this.personalForm = personalForm;
        this.providentFundForm = providentFundForm;
        this.formF = formF;
        this.formI = formI;
        this.formQ = formQ;
    }

    public CompleteFormDTO() {
    }

    /**
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the basicForm
     */
    public BasicFormDTO getBasicForm() {
        return basicForm;
    }

    /**
     * @param basicForm the basicForm to set
     */
    public void setBasicForm(BasicFormDTO basicForm) {
        this.basicForm = basicForm;
    }

    /**
     * @return the personalForm
     */
    public PersonalFormDTO getPersonalForm() {
        return personalForm;
    }

    /**
     * @param personalForm the personalForm to set
     */
    public void setPersonalForm(PersonalFormDTO personalForm) {
        this.personalForm = personalForm;
    }

    /**
     * @return the providentFundForm
     */
    public ProvidentFundFormDTO getProvidentFundForm() {
        return providentFundForm;
    }

    /**
     * @param providentFundForm the providentFundForm to set
     */
    public void setProvidentFundForm(ProvidentFundFormDTO providentFundForm) {
        this.providentFundForm = providentFundForm;
    }

    /**
     * @return the formF
     */
    public FormFDTO getFormF() {
        return formF;
    }

    /**
     * @param formF the formF to set
     */
    public void setFormF(FormFDTO formF) {
        this.formF = formF;
    }

    /**
     * @return the formI
     */
    public FormIDTO getFormI() {
        return formI;
    }

    /**
     * @param formI the formI to set
     */
    public void setFormI(FormIDTO formI) {
        this.formI = formI;
    }

    /**
     * @return the formQ
     */
    public FormQDTO getFormQ() {
        return formQ;
    }

    /**
     * @param formQ the formQ to set
     */
    public void setFormQ(FormQDTO formQ) {
        this.formQ = formQ;
    }
}
