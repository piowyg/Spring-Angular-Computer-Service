import { Component, OnInit } from '@angular/core';
import { Gpu } from '../gpu';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registrator-gpu',
  templateUrl: './registrator-gpu.component.html',
  styleUrls: ['./registrator-gpu.component.css']
})
export class RegistratorGpuComponent implements OnInit {



  gpu: Gpu = new Gpu(0,"",0);
  message:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit(): void {
  }

  public registerNow()
  {
    let resp = this.service.doGpuRegistration(this.gpu);
    resp.subscribe((data)=> this.message = data);
  }
}
