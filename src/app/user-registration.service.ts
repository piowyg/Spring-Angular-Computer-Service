import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Computer } from './computer';
import { Cpu } from './cpu';
import { Gpu } from './gpu';
import { Memory } from './memory';
import { RamMemory } from './ramMemory';
@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http:HttpClient) { }


  public doRegistration( computer: Computer)
  {
    return this.http.post("http://localhost:8080/api/computer",computer,{responseType:'text' as 'json'})
  }

  public doCpuRegistration( cpu: Cpu)
  {
    return this.http.post("http://localhost:8080/api/cpu",cpu,{responseType:'text' as 'json'})
  }

  public doGpuRegistration( gpu: Gpu)
  {
    return this.http.post("http://localhost:8080/api/gpu",gpu,{responseType:'text' as 'json'})
  }

  public doMemoryRegistration( memory: Memory)
  {
    return this.http.post("http://localhost:8080/api/memory",memory,{responseType:'text' as 'json'})
  }

  public doRamMemoryRegistration( ramMemory: RamMemory)
  {
    return this.http.post("http://localhost:8080/api/ramMemory",ramMemory,{responseType:'text' as 'json'})
  }


  public getComputers()
  {
    return this.http.get("http://localhost:8080/api/computers")
  }

  public getCpus()
  {
    return this.http.get("http://localhost:8080/api/cpus")
  }

  public getMemories()
  {
    return this.http.get("http://localhost:8080/api/memories")
  }

  public getRamMemories()
  {
    return this.http.get("http://localhost:8080/api/ramMemories")
  }

  public getGpus()
  {
    return this.http.get("http://localhost:8080/api/gpus")
  }


  public getComputerById(id: number)
  {
    return this.http.get("http://localhost:8080/api/computer/"+id)
  }

  public getCpuById(id: number)
  {
    return this.http.get("http://localhost:8080/api/cpu/"+id)
  }

  public getGpuById(id: number)
  {
    return this.http.get("http://localhost:8080/api/gpu/"+id)
  }
  public getMemoryById(id: number)
  {
    return this.http.get("http://localhost:8080/api/memory/"+id)
  }
  public getRamMemoryById(id: number)
  {
    return this.http.get("http://localhost:8080/api/ramMemory/"+id)
  }



  public deleteComputer(id: number)
  {
    return this.http.delete("http://localhost:8080/api/computer/"+id)
  }

  public deleteCpu(id: number)
  {
    return this.http.delete("http://localhost:8080/api/cpu/"+id)
  }
  public deleteGpu(id: number)
  {
    return this.http.delete("http://localhost:8080/api/gpu/"+id)
  }
  public deleteMemory(id: number)
  {
    return this.http.delete("http://localhost:8080/api/memory/"+id)
  }
  public deleteRamMemory(id: number)
  {
    return this.http.delete("http://localhost:8080/api/ramMemory/"+id)
  }


  public editComputer(computer: Computer)
  {
    return this.http.put("http://localhost:8080/api/computer",computer,{responseType: 'text' as 'json'})
  }
}
