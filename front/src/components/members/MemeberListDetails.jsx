import axios from 'axios';
import React, { useEffect, useState, useRef, Component } from 'react'
import OutputPair from '../../shared/OutputPair';

const MemeberListDetails = ({ id }) => {
    const [obj, setObj] = useState({})

    useEffect(() => {

        axios.get(`http://localhost:8080/api/libraryMembers/${id}`).then(res => {
            setObj(res.data.data)
        });
    }, [])

    return <>
        <OutputPair label="نام" value={obj.name} />
        <OutputPair label="تخلص" value={obj.lastName} />
        <OutputPair label="نام پدر" value={obj.fatherName} />
        <OutputPair label="راجتسرنمبر" value={obj.registerNumber} />
        <OutputPair label="درجه " value={obj.degree} />
        <OutputPair label="ولایت" value={obj.province} />
        <OutputPair label="شماره تماس" value={obj.phone} />
        <OutputPair label="ادرس فعلی" value={obj.currentAddress} />
        <OutputPair label="ضمانت" value={obj.guarantee} />
        <OutputPair label=" کتابخانه" value={obj.library ? obj.library.name : ''} />
        <OutputPair label=" نمبرتزکره" value={obj.identityNumber} />
        <OutputPair label="وظیفه" value={obj.job} />
        <OutputPair label="سال ثبت" value={obj.jointYear} />
    
    </>
}
export default MemeberListDetails