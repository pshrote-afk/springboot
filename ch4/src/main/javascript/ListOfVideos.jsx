import { useEffect, useState } from "react";

export default function ListOfVideos()
{
    const [data, setData] = useState([]);
    useEffect(()=>{
        fetch("/api/videos")
        .then(r => r.json())
        .then(setData)
        .catch(console.error);
    }, []);
    
    return (
        <ul>
            {data.map((v, i) => <li key={i}>{v.name}</li>)}
        </ul>
    );
}