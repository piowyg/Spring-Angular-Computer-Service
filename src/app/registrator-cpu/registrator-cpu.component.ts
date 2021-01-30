import { Component, OnInit } from '@angular/core';
import { Cpu } from '../cpu';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registrator-cpu',
  templateUrl: './registrator-cpu.component.html',
  styleUrls: ['./registrator-cpu.component.css']
})
export class RegistratorCpuComponent implements OnInit {

  cpu:  Cpu = new Cpu(0,"",0);
  message:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit(): void {
  }

  public registerNow()
  {
    let resp = this.service.doCpuRegistration(this.cpu);
    resp.subscribe((data)=> this.message = data);
  }
}
