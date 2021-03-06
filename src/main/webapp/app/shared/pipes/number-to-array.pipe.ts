import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'numberToArray',
})
export class NumberToArrayPipe implements PipeTransform {
  transform(value: number): number[] {
    const res = [];
    for (let i = 0; i < value; i++) {
      res.push(i);
    }
    return res;
  }
}
