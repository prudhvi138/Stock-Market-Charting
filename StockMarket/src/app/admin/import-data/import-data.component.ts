import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UploadService } from 'src/app/services/upload.service';

@Component({
  selector: 'app-import-data',
  templateUrl: './import-data.component.html',
  styleUrls: ['./import-data.component.css']
})
export class ImportDataComponent implements OnInit {
  uploadForm:FormGroup;
  constructor( private formBuilder:FormBuilder,private uploadService:UploadService) { }
file:File;
isError:boolean = false;
errorMessage : string ="";
  ngOnInit() {

    this.uploadForm=this.formBuilder.group({
      id:[],
      excel: ['',Validators.required],
     });
  }

  onFileChange(e){
    this.file = e.target.files[0];
  }

  upload(){

    const uploadSheetData = new FormData();
    
    uploadSheetData.append("stockSheet" , this.file,this.file.name);
    this.uploadService.uploadStocksSheet(uploadSheetData).subscribe(data => {
      console.log("Uploaded");
      alert("uploded successfully")
      this.uploadForm.reset()
    });

  }

}
