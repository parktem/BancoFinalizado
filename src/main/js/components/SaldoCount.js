import React from "react";


export default class UserCount extends React.Component {

	constructor(props) {
		super(props)
		this.state = { count: props.count.length, users: props.count }
	}

	render() {

		for (var key in this.state.users) {

		}

		return (
			<div>

			</div>
		)



	}
}