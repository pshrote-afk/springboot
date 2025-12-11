import React, { useState } from "react";

export default function NewVideo()
{
    const [name, setName] = useState("");

    async function submit(e)
    {
        e.preventDefault();             // stop page reload
        await fetch("/api/videos", {
            method: "POST",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify({name})
        });    
        window.location.href = "/react";      // after saving, redirect here  
    }

    // form uses submit handler
    return (
        <form onSubmit={submit}>            
            <input 
            value={name}
            onChange={e=>setName(e.target.value)} />
            <button type="submit">Submit</button>
        </form>
    );
}
