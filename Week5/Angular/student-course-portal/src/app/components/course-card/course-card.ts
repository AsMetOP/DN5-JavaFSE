import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';

interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
}

@Component({
  selector: 'app-course-card',
  imports: [],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges) {
    if (changes['course']) {
      console.log('Previous course:', changes['course'].previousValue);
      console.log('Current course:', changes['course'].currentValue);
    }
  }
}