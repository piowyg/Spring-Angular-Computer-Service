import { Component, OnInit } from '@angular/core';
import { Memory } from '../memory';
import { UserRegistrationService } from '../user-registration.service';
@Component({
  selector: 'app-registrator-memory',
  templateUrl: './registrator-memory.component.html',
  styleUrls: ['./registrator-memory.component.css']
})
export class RegistratorMemoryComponent implements OnInit {

  memory: Memory = new Memory(0,"",0)
  message:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit(): void {
  }

  public registerNow()
  {
    let resp = this.service.doMemoryRegistration(this.memory);
    resp.subscribe((data)=> this.message = data);
  }
}
