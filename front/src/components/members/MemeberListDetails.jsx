import axios from 'axios';
import React, { useEffect, useState, useRef, Component } from 'react'
import { Link } from "react-router-dom";
import { Toast } from 'primereact/toast';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column'
import { useParams } from "react-router"
const MemeberListDetails=()=>{
    const { id } = useParams()
    const [obj, setObj] = useState({})
   // const [libraryMembers, setLibraryMembers] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/api/libraryMembers/${id}`).then(res => {
            setObj(res.data.data)
        });
    }, [])
    return <>
    <div className="container">

        <div>
            <div className="card"  >
                <DataTable value={setObj} responsiveLayout="scroll" size='small' >
                    <Column field="name" header="نام" />
                    <Column field="lastName" header="تخلص" />
                    <Column field="fatherName" header="نام پدر" />
                    <Column field="registerNumber" header="راجستر نمبر" />
                    <Column field="degree" header="درجه" />
                    <Column field="province" header="ولایت" />
                    <Column field="phone" header="شماره تماس" />
                    <Column field="currentAddress" header="ادرس فعلی" />
                    <Column field="guarantee" header="ضمانت" />
                    <Column field="{obj.library ? obj.library.name : ''}" header="کتابخانه" />
                </DataTable>
            </div>
        </div>
    </div>

    

</>
}
export default MemeberListDetails