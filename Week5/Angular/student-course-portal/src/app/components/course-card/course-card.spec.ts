import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { Router } from '@angular/router';
import { By } from '@angular/platform-browser';
import { CourseCard } from './course-card';
import { Course } from '../../models/course.model';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;
  let store: MockStore;

  const mockCourse: Course = {
    id: '1',
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'
  };

  const initialState = {
    enrollment: { enrolledCourseIds: [] }
  };

  beforeEach(async () => {
    const routerSpy = jasmine.createSpyObj('Router', ['navigate']);

    await TestBed.configureTestingModule({
      imports: [CourseCard],
      providers: [
        provideMockStore({ initialState }),
        { provide: Router, useValue: routerSpy }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    component.course = mockCourse;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render the course name from @Input', () => {
    const nameEl = fixture.debugElement.query(By.css('p'));
    expect(nameEl.nativeElement.textContent).toContain('Data Structures');
  });

  it('should dispatch enrollInCourse when Enroll is clicked (not yet enrolled)', () => {
    spyOn(store, 'dispatch');
    fixture.detectChanges();
    const enrollButton = fixture.debugElement.query(By.css('button'));
    enrollButton.nativeElement.click();
    expect(store.dispatch).toHaveBeenCalled();
  });

  it('should log previous and current course on ngOnChanges', () => {
    spyOn(console, 'log');
    component.ngOnChanges({
      course: {
        previousValue: undefined,
        currentValue: mockCourse,
        firstChange: true,
        isFirstChange: () => true
      }
    });
    expect(console.log).toHaveBeenCalledWith('Previous course:', undefined);
    expect(console.log).toHaveBeenCalledWith('Current course:', mockCourse);
  });
});