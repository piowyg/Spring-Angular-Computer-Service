import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDeleteGpuComponent } from './search-delete-gpu.component';

describe('SearchDeleteGpuComponent', () => {
  let component: SearchDeleteGpuComponent;
  let fixture: ComponentFixture<SearchDeleteGpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchDeleteGpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDeleteGpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
