import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete-ram-memory',
  templateUrl: './search-delete-ram-memory.component.html',
  styleUrls: ['./search-delete-ram-memory.component.css']
})
export class SearchDeleteRamMemoryComponent implements OnInit {

  ramMemories:any;
  id:number;

  constructor(private service:UserRegistrationService) { }
 
  public deleteRamMemory(id:number){
    let resp= this.service.deleteRamMemory(id);
    resp.subscribe((data)=>this.ramMemories=data);
   }

   public getRamMemoryById(){
    this.ramMemories = this.ramMemories.data_candidate_source
    let resp= this.service.getRamMemoryById(this.id);
    resp.subscribe((data)=>this.ramMemories=data);
   }


  ngOnInit(): void {
    let resp = this.service.getRamMemories()
    resp.subscribe((data)=> this.ramMemories=data);
  }
}
