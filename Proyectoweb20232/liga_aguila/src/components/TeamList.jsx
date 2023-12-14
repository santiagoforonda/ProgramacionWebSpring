import React from "react";
import TeamCard from "./TeamCard";

function TeamList({teams}){


    return(
        <div>

            {
                teams.map( (team) => (<TeamCard key={team.id} team={team}> </TeamCard> ))
            }


        </div>

    );
}

export default TeamList;