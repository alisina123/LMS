import axios from 'axios';
import React, { useEffect, useState, useRef, Component } from 'react'
import { Link } from "react-router-dom";
import { Toast } from 'primereact/toast';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column'
import { Dialog } from 'primereact/dialog';
import { Button } from 'primereact/button';
import CreateMember from './CreateMember';
import MemeberListDetails from './MemeberListDetails';

export const MemberList = () => {

    const [libraryMembers, setLibraryMembers] = useState([]);
    const toast = useRef(null);
    const [visible, setVisible] = useState(false);
    const [detailsVisble,setDetailsVisble]=useState(false);
    const [selectedId, setSelectedId] = useState();
    
    const onHide=()=>{
        setVisible(false);
        setSelectedId(null);
    }
    useEffect(() => {

        axios.get("http://localhost:8080/api/libraryMembers").then(response => {
            console.log(response.data.data);
            setLibraryMembers(response.data.data);
        });

    }, []);
    const detailsBody = (rowData) => {
        console.log(rowData)
        
        return <Button onClick={() => {setDetailsVisble(true); setSelectedId(rowData.id)}} size="small" icon="pi pi-eye"  > </Button>

    }
    const editBody = (rowData) => {
        console.log(rowData)
        
        return <Button onClick={() => {setVisible(true); setSelectedId(rowData.id)}}  size="small" icon="pi pi-pencil"  > </Button>

    }
    const deleteMember = (id) => {
        toast.current.show({ severity: 'success', summary: 'Success Message', detail: 'Message Content', life: 3000 });
        axios.delete(`http://localhost:8080/api/libraryMembers/${id}`).then(res => {

            setLibraryMembers(libraryMembers.filter(function (value, index, arr) { return value.id != id; }))
        })
    }


    const deleteBody = (rowData) => {
        console.log(rowData)
        return <Button icon="pi pi-trash" onClick={() => deleteMember(rowData.id)} ></Button>
    }
    const header = (
        <div className="table-header" dir='rtl'>
            <Button onClick={() => setVisible(true)} label="اضافه نمودن" size="small" icon="pi pi-plus"  > </Button>
        </div>
    );
    return <>
        <div className="container">
            <Toast ref={toast} />
            <div>
                <div className="card"  >
                    <DataTable value={libraryMembers} header={header} responsiveLayout="scroll" size='small' >
                        <Column field="name" header="نام" />
                        <Column field="lastName" header="تخلص" />
                        <Column field="fatherName" header="نام پدر" />
                        <Column field="registerNumber" header="راجستر نمبر" />
                        <Column field="degree" header="درجه" />
                        <Column field="province" header="ولایت" />
                        <Column field="phone" header="شماره تماس" />
                        <Column field="currentAddress" header="ادرس فعلی" />
                        <Column field="guarantee" header="ضمانت" />
                        <Column field="library.name" header="کتابخانه" />
                        <Column header="ویرایش" body={editBody} />
                        <Column header="جزیات" body={detailsBody} />
                        <Column header="حزف" body={deleteBody} />
                    </DataTable>
                </div>
            </div>
        </div>

        <Dialog header="ویرایش" style={{ width: '90%', dir: 'rtl' }} position="top" visible={visible} onHide={onHide  }>
            <CreateMember id={selectedId}/>
        </Dialog>
        <Dialog header="اضافه کردن عضو جدید" style={{ width: '90%', dir: 'rtl' }} position="top" visible={detailsVisble} onHide={() => setDetailsVisble(false)}>
            <MemeberListDetails id={selectedId}/>
        </Dialog>

    </>


}
export default MemberList