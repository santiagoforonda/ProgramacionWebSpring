import React from "react";
import MatchCard from "./MatchCard";

function MatchList({partidos}){
    return(
        <div>
            {
                partidos.map((partido)=>(<MatchCard key={partido.id} match={partido}></MatchCard>))
            }

        </div>


    );
}


export default MatchList;