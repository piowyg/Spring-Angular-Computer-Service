import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-serach-delete',
  templateUrl: './serach-delete.component.html',
  styleUrls: ['./serach-delete.component.css']
})
export class SerachDeleteComponent implements OnInit {

  computers:any;
  id: number;

  constructor(private service:UserRegistrationService) {}

  public deleteComputer(id:number){
    let resp= this.service.deleteComputer(id);
    resp.subscribe((data)=>this.computers=data);
   }

   public getComputerById(){
    this.computers = this.computers.data_candidate_source
    let resp= this.service.getComputerById(this.id);
    console.log(resp)
    resp.subscribe((data)=>this.computers=data);
   }

  ngOnInit(): void {
    let resp = this.service.getComputers()
    resp.subscribe((data)=> this.computers=data);
  }

}
