

import React, { useState } from 'react';
import { TabMenu } from 'primereact/tabmenu';
import { Button } from 'primereact/button';

const Header = () => {

    const [activeIndex, setActiveIndex] = useState(0);

    const items = [
        { label: 'اعضای کتابخانه', icon: 'pi pi-fw pi-users', command: (event) => { window.location.hash = "/memberList"; } }, 
        { label: 'کتاب ها', icon: 'pi pi-fw pi-book', command: (event) => { window.location.hash = "/fileupload"; } },
        { label: 'کتابخانه', icon: 'pi pi-fw pi-book', command: (event) => { window.location.hash = "/fileupload"; } },
        { label: 'گرفتن امانت', icon: 'pi pi-fw pi-users', command: (event) => { window.location.hash = "/fileupload"; } },
        { label: 'Settings', icon: 'pi pi-fw pi-cog', command: (event) => { window.location.hash = "/fileupload"; } }
    ];

    return <TabMenu model={items} />
}
export default Header

