import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete-cpu',
  templateUrl: './search-delete-cpu.component.html',
  styleUrls: ['./search-delete-cpu.component.css']
})
export class SearchDeleteCpuComponent implements OnInit {

  cpus:any;
  id:number;

  constructor(private service:UserRegistrationService) { }

  public deleteCpu(id:number){
    let resp= this.service.deleteCpu(id);
    resp.subscribe((data)=>this.cpus=data);
   }

   public getCpuById(){
    this.cpus = this.cpus.data_candidate_source
    let resp= this.service.getCpuById(this.id);
    console.log(resp)
    resp.subscribe((data)=>this.cpus=data);
   }


  ngOnInit(): void {
    let resp = this.service.getCpus()
    resp.subscribe((data)=> this.cpus=data);
  }

}
