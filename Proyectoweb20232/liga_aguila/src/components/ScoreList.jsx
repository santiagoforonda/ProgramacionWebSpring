import React from "react";
import ScoreCard from "./ScoredCard";

function ScoreList({scores}){





    return(
        <div>

            {
                scores.map((score)=> (<ScoreCard key={score.id} resultado={score} resultados={scores} ></ScoreCard>))
            }
        </div>


    );

}


export default ScoreList;