import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { SerachDeleteComponent } from './serach-delete/serach-delete.component';
import { UserRegistrationService } from './user-registration.service';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { EditorComponent } from './editor/editor.component';
import { RegistratorCpuComponent } from './registrator-cpu/registrator-cpu.component';
import { SearchDeleteCpuComponent } from './search-delete-cpu/search-delete-cpu.component';
import { RegistratorGpuComponent } from './registrator-gpu/registrator-gpu.component';
import { SearchDeleteGpuComponent } from './search-delete-gpu/search-delete-gpu.component';
import { RegistratorMemoryComponent } from './registrator-memory/registrator-memory.component';
import { SearchDeleteMemoryComponent } from './search-delete-memory/search-delete-memory.component';
import { SearchDeleteRamMemoryComponent } from './search-delete-ram-memory/search-delete-ram-memory.component';
import { RegistratorRamMemoryComponent } from './registrator-ram-memory/registrator-ram-memory.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    SerachDeleteComponent,
    EditorComponent,
    RegistratorCpuComponent,
    SearchDeleteCpuComponent,
    RegistratorGpuComponent,
    SearchDeleteGpuComponent,
    RegistratorMemoryComponent,
    SearchDeleteMemoryComponent,
    SearchDeleteRamMemoryComponent,
    RegistratorRamMemoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [UserRegistrationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
