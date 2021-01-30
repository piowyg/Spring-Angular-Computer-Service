import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete-memory',
  templateUrl: './search-delete-memory.component.html',
  styleUrls: ['./search-delete-memory.component.css']
})
export class SearchDeleteMemoryComponent implements OnInit {

  memories:any;
  id:number;

  constructor(private service:UserRegistrationService) { }
 
  public deleteMemory(id:number){
    let resp= this.service.deleteMemory(id);
    resp.subscribe((data)=>this.memories=data);
   }

   public getMemoryById(){
    this.memories = this.memories.data_candidate_source
    let resp= this.service.getMemoryById(this.id);
    resp.subscribe((data)=>this.memories=data);
   }


  ngOnInit(): void {
    let resp = this.service.getMemories()
    resp.subscribe((data)=> this.memories=data);
  }
}
