import React from "react";
import { addUser } from "../actions/userActions"

export default class AddUserForm extends React.Component {

  constructor() {
    super();
    this.state = {

      numero: "",
      saldo: "",
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
      this.addUser();
      console.log("item inserted")
    }
  }

  addUser() {
    addUser(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
      <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
        <div>
          <a href=".../webapp/WEB-INF/jsp/pepe.jsp">asdasdasd</a>
          <input type="text" class="form-control"
            name="numero"
            placeholder="Add a new numero"
            value={this.state.nombre}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            name="saldo"
            placeholder="Add a new saldo."
            value={this.state.apellido}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
        </div>
        <div>
          <button className="btn btn-default" type="button" onClick={this.addUser.bind(this)}>Insert User</button>
        </div>
      </div>
    );
  }
}