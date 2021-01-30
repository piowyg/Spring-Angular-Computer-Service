import { Component, OnInit } from '@angular/core';
import { Computer } from '../computer';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {


  computer: Computer = new Computer(0,"",0);
  message:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit(): void {
  }

  public registerNow()
  {
    let resp = this.service.doRegistration(this.computer);
    resp.subscribe((data)=> this.message = data);
  }
}
