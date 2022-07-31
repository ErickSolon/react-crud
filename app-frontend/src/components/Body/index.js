import React from "react";

const Body = ({ body }) => {
  return (
      <body>
        <h2>{body?body:"Digite o body da página!"}</h2>
      </body>
    );
}

export default Body;