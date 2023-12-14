import React from "react";
import {Routes, Route} from "react-router-dom";
import Home from "./pages/Home";
import RegisterMatch from "./pages/RegisterMatch";
import RegisterTeam from "./pages/RegisterTeam";
import ListResults from "./pages/ListResults";


function RouterManager(){

    return(
        <Routes>
            <Route path="/" element={<Home></Home>}></Route>
            <Route path="/register_team" element={<RegisterTeam/>}></Route>
            <Route path="/register_match" element={<RegisterMatch></RegisterMatch>}></Route>
            <Route path ="/listResults" element={<ListResults/>}></Route>
        </Routes>

    );

}

export default RouterManager;