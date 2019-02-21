import React from "react";
import UserItem from "./UserItem"
import UserCount from "./UserCount"
import SaldoCount from "./SaldoCount"

export default class UserList extends React.Component {

	constructor(props) {
		super(props)
		this.state = { users: [] }
	}

  render() {
		if (this.state.users.length == 0) {	
			fetch('/api/v1/user/list/')
			.then((response) => {
				return response.json();
			})			
			.then((user) => {
        		this.setState({ users: user })
      		})
			
		}

		if (this.state.users.length > 0) {
		
			var userItems = [];
			this.state.users.forEach(
				(usuario) => {
					userItems.push(<UserItem user={usuario} />)
				}
			)
			
		
		return (
				<div>
					<table class="align-middle">
					{userItems}
					<UserCount  count={this.state.users}/>
					</table>
				</div>
			)
			
		
		} else {
			return <p className="text-center">Loading users...</p>
		}


    
  }
}