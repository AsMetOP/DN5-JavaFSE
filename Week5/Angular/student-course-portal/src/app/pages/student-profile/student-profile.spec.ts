import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { By } from '@angular/platform-browser';
import { StudentProfile } from './student-profile';
import { Course } from '../../models/course.model';

describe('StudentProfile', () => {
  let component: StudentProfile;
  let fixture: ComponentFixture<StudentProfile>;
  let store: MockStore;

  const mockCourses: Course[] = [
    { id: '1', name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' }
  ];

  const initialState = {
    course: { courses: mockCourses, loading: false, error: null },
    enrollment: { enrolledCourseIds: ['1'] }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentProfile],
      providers: [provideMockStore({ initialState })]
    }).compileComponents();

    fixture = TestBed.createComponent(StudentProfile);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render enrolled courses from initial state', () => {
    const text = fixture.debugElement.query(By.css('h2')).nativeElement.parentElement.textContent;
    expect(text).toContain('Data Structures');
  });

  it('should reflect an updated state when store.setState is called', () => {
    store.setState({
      course: { courses: [], loading: true, error: null },
      enrollment: { enrolledCourseIds: [] }
    });
    fixture.detectChanges();
    const text = fixture.nativeElement.textContent;
    expect(text).toContain("haven't enrolled");
  });
});