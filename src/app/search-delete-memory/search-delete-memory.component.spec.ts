import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDeleteMemoryComponent } from './search-delete-memory.component';

describe('SearchDeleteMemoryComponent', () => {
  let component: SearchDeleteMemoryComponent;
  let fixture: ComponentFixture<SearchDeleteMemoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchDeleteMemoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDeleteMemoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
