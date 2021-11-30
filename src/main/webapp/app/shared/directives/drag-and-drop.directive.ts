import { Directive, EventEmitter, HostListener, Output } from '@angular/core';

@Directive({
  selector: '[jhiDragAndDrop]',
})
export class DragAndDropDirective {
  @Output() fileDropped = new EventEmitter();

  constructor() {}

  @HostListener('dragover', ['$event'])
  onDragOver(event: DragEvent): void {
    event.preventDefault();
    event.stopPropagation();
  }

  @HostListener('dragleave', ['$event'])
  onDragLeave(event: DragEvent): void {
    event.preventDefault();
    event.stopPropagation();
  }

  @HostListener('drop', ['$event'])
  onDrop(event: DragEvent): void {
    event.preventDefault();
    event.stopPropagation();
    const files = event.dataTransfer?.files || [];
    this.fileDropped.emit(files[0]);
  }
}
