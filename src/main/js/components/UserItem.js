import React from "react";
import Delete from "./Delete"
export default class UserItem extends React.Component {

  constructor(props) {
    super(props)
  }

  render() {

    const { user } = this.props;

    return (

      <tr key={user.numero}>
        <td>Numero de cuenta: {user.numero}</td> <td>Saldo: {user.saldo}</td>
      </tr>

    );
  }
}
