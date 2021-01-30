import { Component, OnInit } from '@angular/core';
import { RamMemory } from '../ramMemory';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registrator-ram-memory',
  templateUrl: './registrator-ram-memory.component.html',
  styleUrls: ['./registrator-ram-memory.component.css']
})
export class RegistratorRamMemoryComponent implements OnInit {

  ramMemory: RamMemory = new RamMemory(0,"",0)
  message:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit(): void {
  }

  public registerNow()
  {
    let resp = this.service.doRamMemoryRegistration(this.ramMemory);
    resp.subscribe((data)=> this.message = data);
  }
}
