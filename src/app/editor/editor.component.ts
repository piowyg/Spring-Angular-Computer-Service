import { Component, OnInit } from '@angular/core';
import { Computer } from '../computer';
import { ActivatedRoute } from '@angular/router';
import { UserRegistrationService } from '../user-registration.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

   computer: Computer //= new Computer(id,"Gaming staff",3500);
   computers: any;
   message:any;

  constructor(private route: ActivatedRoute,private service:UserRegistrationService) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    console.log(id)
   // this.computer.id = id;
   //this.computers = this.computers.data_candidate_source
   
  //  let resp= this.service.getComputerById(id)
  //   this.computer=resp;
  // //  resp.subscribe((data)=>this.computers=data);
  //  console.log(this.computers)
    //this.computer = this.computers[0];
   // console.log(this.computers.first())
   }

  public registerNow()
  {
    let resp = this.service.doRegistration(this.computer);
    resp.subscribe((data)=> this.message = data);
  }
}
