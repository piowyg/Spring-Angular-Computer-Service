import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDeleteCpuComponent } from './search-delete-cpu.component';

describe('SearchDeleteCpuComponent', () => {
  let component: SearchDeleteCpuComponent;
  let fixture: ComponentFixture<SearchDeleteCpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchDeleteCpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDeleteCpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
