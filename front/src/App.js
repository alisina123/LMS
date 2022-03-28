import logo from './logo.svg';
import './App.css';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import Demo from './Demo.css';
import NavBar from './shared/NavBar';
import Home from './shared/Home';
import Header from './shared/Header';
import Footer from './shared/Footer';
import { Card } from 'primereact/card';
import "/node_modules/primeflex/primeflex.css";
import "primeicons/primeicons.css";
import MemberList from './components/members/MemberList';
import MemeberListDetails from './components/members/MemeberListDetails';
import {
  BrowserRouter,
  Routes,
  Route,
  HashRouter
} from "react-router-dom";
import CreateMember from './components/members/CreateMember';

function App() {
  return (
    <div className="App" dir='rtl'>
      <div style={{ width: '90%' }}>
        <Card style={{ marginRight: '4em',marginLeft:'-6em'}}>
          <Header />

          <HashRouter>
            <Routes>
              <Route index ="/" element={<MemberList />} />
              <Route path="/memberList" element={<MemberList />} />
              <Route path='/createMember' element={<CreateMember />} />
              <Route path='/memeberListDetails' element={<MemeberListDetails />} />
            </Routes>
          </HashRouter>

        </Card>
      </div>
    </div>
  );
}

export default App;
