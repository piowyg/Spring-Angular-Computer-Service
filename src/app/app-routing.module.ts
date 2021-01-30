import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditorComponent } from './editor/editor.component';
import { RegistrationComponent } from './registration/registration.component';
import { SerachDeleteComponent } from './serach-delete/serach-delete.component';
import { RegistratorCpuComponent } from './registrator-cpu/registrator-cpu.component'
import { SearchDeleteCpuComponent } from './search-delete-cpu/search-delete-cpu.component';
import { RegistratorGpuComponent } from './registrator-gpu/registrator-gpu.component'
import { SearchDeleteGpuComponent } from './search-delete-gpu/search-delete-gpu.component';
import { RegistratorMemoryComponent } from './registrator-memory/registrator-memory.component'
import { SearchDeleteMemoryComponent } from './search-delete-memory/search-delete-memory.component';
import { RegistratorRamMemoryComponent } from './registrator-ram-memory/registrator-ram-memory.component'
import { SearchDeleteRamMemoryComponent } from './search-delete-ram-memory/search-delete-ram-memory.component';
const routes: Routes = [
  {path:"api/computer",component:RegistrationComponent},
  {path:"api/computers",component: SerachDeleteComponent},
  // {path:"api/computer/:id" ,component:EditorComponent},
  {path:"api/cpu",component:RegistratorCpuComponent},
  {path:"api/cpus",component:SearchDeleteCpuComponent},
  {path:"api/gpu",component:RegistratorGpuComponent},
  {path:"api/gpus",component:SearchDeleteGpuComponent},
  {path:"api/memory",component:RegistratorMemoryComponent},
  {path:"api/memories",component:SearchDeleteMemoryComponent},
  {path:"api/ramMemory",component:RegistratorRamMemoryComponent},
  {path:"api/ramMemories",component:SearchDeleteRamMemoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
