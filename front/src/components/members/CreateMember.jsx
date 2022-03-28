import React, { useEffect, useState, useRef } from 'react';
import { useForm, Controller } from 'react-hook-form';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';
import { Calendar } from 'primereact/calendar';
import { Password } from 'primereact/password';
import { Checkbox } from 'primereact/checkbox';
import { Dialog } from 'primereact/dialog';
import { Divider } from 'primereact/divider';
import { classNames } from 'primereact/utils'
import { useNavigate } from 'react-router-dom';
import { Toast } from 'primereact/toast';
import axios from 'axios';
const CreateMember = ({ id }) => {
    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData, libraryMembers, setlibraryMember] = useState({});
    const [libraries, setLibraries] = useState([]);
    const navigate = useNavigate();
    const toast = useRef(null);
    const showSuccess = () => {
        toast.current.show({ severity: 'success', summary: 'Success Message', detail: 'Message Content', life: 3000 });
    }
    const defaultValues = {
        name: '',
        lastName: '',
        fatherName: '',
        registerNumber: '',
        degree: '',
        province: '',
        phone: '',
        currentAddress: '',
        identityNumber: '',
        guarantee: '',
        jointYear: '',
        job: '',
        accept: false
    }

    useEffect(() => {
        if (id) {
            axios.get(`http://localhost:8080/api/libraryMembers/${id}`).then(res => {
                reset(res.data.data);
                
            });
        } else {
            reset()
        }

        axios.get("http://localhost:8080/api/libraries").then(response => {
            setLibraries(response.data.data);
        });

    }, [id]);

    const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });

    const onSubmit = (data) => {
        console.log(data);
        axios.post("http://localhost:8080/api/libraryMembers", data).then(response => {
            console.log(response.data);
        });
        reset();
        navigate('/memberList');
        toast.current.show({ severity: 'success', summary: 'Success Message', detail: 'Order submitted' });

    };

    const getFormErrorMessage = (name) => {
        return errors[name] && <small className="p-error">{errors[name].message}</small>
    };
    const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;

    return <>
        <div class="card">
            <form onSubmit={handleSubmit(onSubmit)} className="p-fluid" dir='rtl'>
                <div class="formgrid grid">
                    <div class="field col-12 md:col-3">
                        <span className="p-float-label">
                            <Controller name="name" control={control} rules={{ required: 'نام الازمی است.' }} render={({ field, fieldState }) => (
                                <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="name" className={classNames({ 'p-error': errors.name })}>نام*</label>
                        </span>
                        {getFormErrorMessage('name')}
                    </div>
                    <div class="field col-12 md:col-3">
                        <span className="p-float-label">
                            <Controller name="lastName" control={control} rules={{ required: 'تخلص الازمی است.' }} render={({ field, fieldState }) => (
                                <InputText id={field.lastName} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="lastName" className={classNames({ 'p-error': errors.lastName })}>تخلص الازمی است*</label>
                        </span>
                        {getFormErrorMessage('lastName')}
                    </div>
                    <div class="field col-3">
                        <span className="p-float-label">
                            <Controller name="fatherName" control={control} rules={{ required: 'نام پدر الازمی است.' }} render={({ field, fieldState }) => (
                                <InputText id={field.fatherName} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="fatherName" className={classNames({ 'p-error': errors.fatherName })}>نام پدر*</label>
                        </span>
                        {getFormErrorMessage('fatherName')}
                    </div>
                    <div class="field col-12 md:col-3">
                        <span className="p-float-label">
                            <Controller name="registerNumber" control={control} rules={{ required: 'راجستر نمبرالازمی است.' }} render={({ field, fieldState }) => (
                                <InputText id={field.registerNumber} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="registerNumber" className={classNames({ 'p-error': errors.registerNumber })}>راجستر نمبر*</label>
                        </span>
                        {getFormErrorMessage('registerNumber')}
                    </div>
                    <div class="field col-12 md:col-3">
                        <span className="p-float-label">
                            <Controller name="degree" control={control} rules={{ required: 'درجه تحصیلی الازمی است.' }} render={({ field, fieldState }) => (
                                <InputText id={field.degree} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="degree" className={classNames({ 'p-error': errors.degree })}>درجه تحصیل*</label>
                        </span>
                        {getFormErrorMessage('degree')}
                    </div>
                    <div class="field col-12 md:col-3">
                        <span className="p-float-label">
                            <Controller name="province" control={control} rules={{ required: 'ولایت الازمی است.' }} render={({ field, fieldState }) => (
                                <InputText id={field.province} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                            )} />
                            <label htmlFor="province" className={classNames({ 'p-error': errors.province })}>ولایت*</label>
                        </span>
                        {getFormErrorMessage('province')}
                    </div>
                    <div class="field col-12 md:col-3"><span className="p-float-label">
                        <Controller name="phone" control={control} rules={{ required: 'شماره تماس الازمی است.' }} render={({ field, fieldState }) => (
                            <InputText id={field.phone} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="phone" className={classNames({ 'p-error': errors.phone })}>شماره تماس*</label>
                    </span>
                        {getFormErrorMessage('phone')}</div>
                    <div class="field col-12 md:col-3"> <span className="p-float-label">
                        <Controller name="currentAddress" control={control} rules={{ required: 'ادرس فعلی لازم است.' }} render={({ field, fieldState }) => (
                            <InputText id={field.currentAddress} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="currentAddress" className={classNames({ 'p-error': errors.currentAddress })}>ادرس فعلی*</label>
                    </span>
                        {getFormErrorMessage('currentAddress')}</div>
                    <div class="field col-12 md:col-3"> <span className="p-float-label">
                        <Controller name="identityNumber" control={control} rules={{ required: 'شماره تزکره الازمی است.' }} render={({ field, fieldState }) => (
                            <InputText id={field.identityNumber} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="identityNumber" className={classNames({ 'p-error': errors.identityNumber })}>شماره تزکره*</label>
                    </span>
                        {getFormErrorMessage('identityNumber')}</div>
                    <div class="field col-12 md:col-3"><span className="p-float-label">
                        <Controller name="guarantee" control={control} rules={{ required: 'ضمانت الازمی است.' }} render={({ field, fieldState }) => (
                            <InputText id={field.guarantee} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="guarantee" className={classNames({ 'p-error': errors.guarantee })}>ضمانت*</label>
                    </span>
                        {getFormErrorMessage('guarantee')}</div>
                    <div class="field col-12 md:col-3"> <span className="p-float-label">
                        <Controller name="jointYear" control={control} rules={{ required: 'سال راجستر الازمی است.' }} render={({ field, fieldState }) => (
                            <InputText id={field.jointYear} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="jointYear" className={classNames({ 'p-error': errors.jointYear })}>سال راجستر*</label>
                    </span>
                        {getFormErrorMessage('jointYear')}</div>
                    <div class="field col-12 md:col-3"><span className="p-float-label">
                        <Controller name="job" control={control} rules={{ required: 'وطیفه الازمی است.' }} render={({ field, fieldState }) => (
                            <InputText id={field.job} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="job" className={classNames({ 'p-error': errors.job })}>وطیفه*</label>
                    </span>
                        {getFormErrorMessage('job')}</div>
                    <div class="field col-12 md:col-3"> <Controller name="library" control={control} render={({ field }) => (
                        <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={libraries} optionLabel="name" placeholder=" کتابخانه را انتخاب کنید" />
                    )} /></div>
                    <div class="field col-12 md:col-3"><div className="field-checkbox">
                        <Controller name="accept" control={control} rules={{ required: true }} render={({ field, fieldState }) => (
                            <Checkbox inputId={field.name} onChange={(e) => field.onChange(e.checked)} checked={field.value} className={classNames({ 'p-invalid': fieldState.invalid })} />
                        )} />
                        <label htmlFor="accept" className={classNames({ 'p-error': errors.accept })}>موافق بااین شرایط*</label>
                    </div></div>
                </div>
                <Button type="submit" icon="pi pi-save" label="دخیره" className="mt-1" />
            </form>

        </div>

    </>
}

export default CreateMember

