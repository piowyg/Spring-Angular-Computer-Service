import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDeleteRamMemoryComponent } from './search-delete-ram-memory.component';

describe('SearchDeleteRamMemoryComponent', () => {
  let component: SearchDeleteRamMemoryComponent;
  let fixture: ComponentFixture<SearchDeleteRamMemoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchDeleteRamMemoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDeleteRamMemoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
