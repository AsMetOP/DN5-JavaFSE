import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Highlight } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { Course } from '../../models/course.model';
import { enrollInCourse, unenrollFromCourse } from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule, Highlight, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: Course;
  isExpanded = false;
  enrolledIds$: Observable<(number | string)[]>;

  constructor(
    private store: Store,
    private router: Router
  ) {
    this.enrolledIds$ = this.store.select(selectEnrolledIds);
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['course']) {
      console.log('Previous course:', changes['course'].previousValue);
      console.log('Current course:', changes['course'].currentValue);
    }
  }

  get cardClasses() {
    return {
      'card--full': this.course?.credits >= 4,
      'expanded': this.isExpanded,
    };
  }

  get borderColor() {
    switch (this.course?.gradeStatus) {
      case 'passed': return 'green';
      case 'failed': return 'red';
      case 'pending': return 'grey';
      default: return 'transparent';
    }
  }

  toggleExpand() {
    this.isExpanded = !this.isExpanded;
  }

  onEnrollClick(enrolledIds: (number | string)[]) {
    if (enrolledIds.includes(this.course.id)) {
      this.store.dispatch(unenrollFromCourse({ courseId: this.course.id }));
    } else {
      this.store.dispatch(enrollInCourse({ courseId: this.course.id }));
    }
  }

  viewDetails() {
    this.router.navigate(['courses', this.course.id]);
  }
}