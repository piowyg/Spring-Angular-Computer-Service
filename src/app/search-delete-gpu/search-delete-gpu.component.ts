import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete-gpu',
  templateUrl: './search-delete-gpu.component.html',
  styleUrls: ['./search-delete-gpu.component.css']
})
export class SearchDeleteGpuComponent implements OnInit {

  gpus:any;
  id:number;

  constructor(private service:UserRegistrationService) { }

  public deleteGpu(id:number){
    let resp= this.service.deleteGpu(id);
    resp.subscribe((data)=>this.gpus=data);
   }

   public getGpuById(){
    this.gpus = this.gpus.data_candidate_source
    let resp= this.service.getGpuById(this.id);
    console.log(resp)
    resp.subscribe((data)=>this.gpus=data);
   }

  ngOnInit(): void {
    let resp = this.service.getGpus()
    resp.subscribe((data)=> this.gpus=data);
  }

}
