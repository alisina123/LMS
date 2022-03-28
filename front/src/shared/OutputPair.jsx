import React from 'react'
const OutputPair = ({ label, value }) => {

    return <div className="field grid" dir='rtl'>
        <b><label  className="col-fixed">{label}:</label></b>
         
        <label className="col-fixed">{value}</label>
        
    </div>
    

}

export default OutputPair