import React from "react";


export default class UserCount extends React.Component {

	constructor(props) {
		super(props)
		this.state = { count: props.count.length, users: props.count }
	}

	render() {

		var acum = 0

		for (let index = 0; index < this.state.count; index++) {
			acum += this.state.users[index].saldo
			
		}


		return (
			<div>
				<tr>
					<td>Salario total:</td><td>{acum}</td>
				</tr>
				se muestran {this.state.count} elementos
			</div>
		)



	}
}