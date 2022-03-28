import axios from 'axios';
import React, { useEffect, useState, useRef, Component } from 'react'
import { Link } from "react-router-dom";
import { Toast } from 'primereact/toast';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column'
import { Dialog } from 'primereact/dialog';
import { Button } from 'primereact/button';
import CreateMember from './CreateMember';
import { Dropdown } from 'primereact/dropdown';
import { InputText } from 'primereact/inputtext';
import MemeberListDetails from './MemeberListDetails';
import { Ripple } from 'primereact/ripple';
import { classNames } from 'primereact/utils';
export const MemberList = () => {

    const [libraryMembers, setLibraryMembers] = useState([]);
    const toast = useRef(null);
    const [visible, setVisible] = useState(false);
    const [detailsVisble,setDetailsVisble]=useState(false);
    const [selectedId, setSelectedId] = useState();
    

    const [first1, setFirst1] = useState(0);
    const [rows1, setRows1] = useState(10);
    const [first2, setFirst2] = useState(0);
    const [rows2, setRows2] = useState(10);
    const [currentPage, setCurrentPage] = useState(1);
    const [pageInputTooltip, setPageInputTooltip] = useState('Press \'Enter\' key to go to this page.');
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
    const onCustomPage1 = (event) => {
        setFirst1(event.first);
        setRows1(event.rows);
        setCurrentPage(event.page + 1);
    }

    const onCustomPage2 = (event) => {
        setFirst2(event.first);
        setRows2(event.rows);
    }

    const onPageInputKeyDown = (event, options) => {
        if (event.key === 'Enter') {
            const page = parseInt(currentPage);
            if (page < 0 || page > options.totalPages) {
                setPageInputTooltip(`Value must be between 1 and ${options.totalPages}.`);
            }
            else {
                const first = currentPage ? options.rows * (page - 1) : 0;

                setFirst1(first);
                setPageInputTooltip('Press \'Enter\' key to go to this page.');
            }
        }
    }

    const onPageInputChange = (event) => {
        setCurrentPage(event.target.value);
    }

  

    const paginatorLeft = <Button type="button" icon="pi pi-refresh" className="p-button-text" />;
    const paginatorRight = <Button type="button" icon="pi pi-cloud" className="p-button-text" />;
    const template1 = {
        layout: 'PrevPageLink PageLinks NextPageLink RowsPerPageDropdown CurrentPageReport',
        'PrevPageLink': (options) => {
            return (
                <button type="button" className={options.className} onClick={options.onClick} disabled={options.disabled}>
                    <span className="p-3">Previous</span>
                    <Ripple />
                </button>
            )
        },
        'NextPageLink': (options) => {
            return (
                <button type="button" className={options.className} onClick={options.onClick} disabled={options.disabled}>
                    <span className="p-3">Next</span>
                    <Ripple />
                </button>
            )
        },
        'PageLinks': (options) => {
            if ((options.view.startPage === options.page && options.view.startPage !== 0) || (options.view.endPage === options.page && options.page + 1 !== options.totalPages)) {
                const className = classNames(options.className, { 'p-disabled': true });

                return <span className={className} style={{ userSelect: 'none' }}>...</span>;
            }

            return (
                <button type="button" className={options.className} onClick={options.onClick}>
                    {options.page + 1}
                    <Ripple />
                </button>
            )
        },
        'RowsPerPageDropdown': (options) => {
            const dropdownOptions = [
                { label: 10, value: 10 },
                { label: 20, value: 20 },
                { label: 50, value: 50 },
                { label: 'All', value: options.totalRecords }
            ];

            return <Dropdown value={options.value} options={dropdownOptions} onChange={options.onChange} />;
        },
        'CurrentPageReport': (options) => {
            return (
                <span className="mx-3" style={{ color: 'var(--text-color)', userSelect: 'none' }}>
                    Go to <InputText size="2" className="ml-1" value={currentPage} tooltip={pageInputTooltip}
                        onKeyDown={(e) => onPageInputKeyDown(e, options)} onChange={onPageInputChange}/>
                </span>
            )
        }
    };
    const template2 = {
        layout: 'RowsPerPageDropdown CurrentPageReport PrevPageLink NextPageLink',
        'RowsPerPageDropdown': (options) => {
            const dropdownOptions = [
                { label: 10, value: 10 },
                { label: 20, value: 20 },
                { label: 50, value: 50 }
            ];

            return (
                <React.Fragment>
                    <span className="mx-1" style={{ color: 'var(--text-color)', userSelect: 'none' }}>Items per page: </span>
                    <Dropdown value={options.value} options={dropdownOptions} onChange={options.onChange} />
                </React.Fragment>
            );
        },
        'CurrentPageReport': (options) => {
            return (
                <span style={{ color: 'var(--text-color)', userSelect: 'none', width: '120px', textAlign: 'center' }}>
                    {options.first} - {options.last} of {options.totalRecords}
                </span>
            )
        }
    };

    const detailsBody = (rowData) => {
        console.log(rowData)
        
        return <Button onClick={() => {setDetailsVisble(true); setSelectedId(rowData.id)}} size="small" icon="pi pi-eye"  > </Button>

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
            
            <Link to="/createMember"><Button to="/createMember" label="اضافه نمودن" size="small" icon="pi pi-plus"  > </Button></Link>
        </div>
    );

   

    return <>
        <div className="container">
            <Toast ref={toast} />
            <div>
                <div className="card"  >
                    <DataTable  value={libraryMembers} header={header} responsiveLayout="scroll" size='small'   paginator 
                    paginatorTemplate="CurrentPageReport FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink RowsPerPageDropdown"
                    currentPageReportTemplate="نشان    {first} به {last} از {totalRecords}" rows={10} rowsPerPageOptions={[10,20,50]}
                    paginatorLeft={paginatorLeft} paginatorRight={paginatorRight}>
                        <Column  header="#" body={(data, p)=><span>{p.rowIndex+1}</span>}/>
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
                        <Column header="جزیات" body={detailsBody} />
                        <Column header="حزف" body={deleteBody} />
                    </DataTable>
                </div>
            </div>
        </div>

       
        <Dialog  style={{ width: '90%', dir: 'rtl' }} position="top" visible={detailsVisble} onHide={() => setDetailsVisble(false)}>
            <MemeberListDetails id={selectedId}/>
        </Dialog> 

    </>


}
export default MemberList