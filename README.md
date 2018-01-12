<h1>SpringBootReuso</h1>

Obs.: Alguns dados são inseridos no H2 ao levantar a aplicação, afim de facilitar os testes.
Script de insert disponível em scripts/create_data.sql

Acesso H2:	/console<br>
JDBC URL:	jdbc:h2:~/db-h2/springboot-h2<br>
User:	sa<br>
Password:	

<h2>ENDPOINTS - https://springbootreuso.herokuapp.com/</h2> 		
<h2>/orders</h2>
GET - Serviço responsável por listar todas as Ordens.<br>
POST - Serviço responsável por adicionar uma nova Ordem.<br>
<h2>/orders/{id}</h2>
GET	- Serviço responsável por retornar uma Ordem com base no ID.<br>
PUT	- Serviço responsável por atualizar a Ordem específica a partir do ID informado.<br>
DELETE	- Serviço responsável por remover a Ordem específica a partir do ID informado.<br>
<h2>/customers</h2>
GET	- Serviço responsável por listar todos os Clientes.<br>
POST	- Serviço responsável por adicionar um novo Cliente.<br>
<h2>/customers/{id}</h2>
GET -	Serviço responsável por retornar um Cliente com base no ID.<br>
PUT	- Serviço responsável por atualizar o Cliente específico a partir do ID informado.<br>
DELETE - Serviço responsável por remover o Cliente específico a partir do ID informado.<br>
<h2>/customers/{id}/orders</h2>
GET	- Serviço responsável por retornar todas as Ordens de um Cliente específico com base no seu ID.<br>
POST - Serviço responsável por adicionar uma nova Ordem ao Cliente específico com base no seu ID.<br>
DELETE - Serviço responsável por remover as Ordens do Cliente específico com base no seu ID.
