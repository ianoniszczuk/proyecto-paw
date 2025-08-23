<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="paw" tagdir="/WEB-INF/tags"%>

<html>
<head>
<title>Proyecto PAW</title>
<link rel="stylesheet" href="<c:url value="/css/components.css"/>" />
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
</head>
<body>

	<div class="app-container">
		<h2>PAW Project</h2>

		<div class="section">
			<div class="flex-container">
				<img src="<c:url value="/images/Independiente.png"/>"
					alt="Independiente" width="200" />
			</div>

		</div>

		<div class="section">
			<h3>Buttons</h3>

			<div class="flex-container">
				<paw:styled-button text="Small Button" size="sm" />
				<paw:styled-button text="Medium Button" size="md" />
				<paw:styled-button text="Large Button" size="lg" />
			</div>

			<div class="flex-container">
				<paw:styled-button text="Click Me"
					onclick="alert('Button clicked!')" />
				<paw:styled-button text="Disabled" disabled="true" />
				<paw:styled-button text="Submit" type="submit" />
			</div>
		</div>

		<div class="section">
			<h3>Cards</h3>

			<div class="flex-container">
				<paw:card title="Product Card"
					description="This is a sample product card with a clean design, perfect for displaying items in your application."
					footer="Price: $99.99" />

				<paw:card title="Service Card"
					description="Another example of a card component demonstrating the flexible layout system."
					footer="Available 24/7" />

				<paw:card title="Information Card"
					description="Cards can be used to display any type of content in a structured and visually appealing way." />
			</div>
		</div>

		<div class="section">
			<h3>Inputs</h3>

			<div class="inputs-container">
				<paw:styled-input name="default" label="Default input" />
				<paw:styled-input name="input2" label="Input with placeholder"
					placeholder="Type something..." />
				<paw:styled-input name="input3" label="Input with error"
					required="true" error="Input can't be empty" />
			</div>

			<div class="inputs-container">
				<paw:styled-input name="password" type="password" label="Password"
					placeholder="Enter password" required="true" />
				<paw:styled-input name="disabled-demo" label="Disabled Input"
					value="This field is disabled" disabled="true" />
				<paw:styled-input name="number-demo" type="number" label="Quantity"
					placeholder="0" />
			</div>
		</div>


	</div>

</body>
</html>