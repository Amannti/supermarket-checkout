import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartItemPositionComponent } from './cart-item-position.component';

describe('CartItemPositionComponent', () => {
  let component: CartItemPositionComponent;
  let fixture: ComponentFixture<CartItemPositionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CartItemPositionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CartItemPositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
