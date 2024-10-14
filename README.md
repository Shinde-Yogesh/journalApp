<h1 align="center">Journal Emotion Analyzer</h1>

<p>This project is a <strong>Journal Emotion Analyzer</strong> that analyzes a person's emotions based on their last 7 days of journal entries. It automatically detects emotions like <strong>happiness</strong>, <strong>sadness</strong>, <strong>anger</strong>, and more, then sends an appropriate email notification based on the detected emotions.</p>

<h2>Features</h2>
<ul>
  <li>📝 Create, Update, and Delete journal entries</li>
  <li>🔍 Analyze emotions based on journal content over the last 7 days</li>
  <li>📧 Send personalized emails based on the user's emotional state (e.g., happy, sad, angry)</li>
  <li>🚀 Built using Java, Spring Boot, Spring Security, and MongoDB</li>
</ul>

<h2>Tech Stack</h2>
<ul>
  <li><strong>Java 17</strong> ☕</li>
  <li><strong>Spring Boot</strong></li>
  <li><strong>Spring Security</strong></li>
  <li><strong>Redis</strong> ⚡ (for caching)</li>
  <li><strong>MongoDB Atlas</strong> 🗄️ (for database management)</li>
  <li><strong>Java Mail Sender</strong> ✉️ (for email notifications)</li>
  <li><strong>Postman</strong> 🛠️ (for API testing)</li>
</ul>

<h2>Table of Contents</h2>
<ul>
  <li><a href="#installation">Installation</a></li>
  <li><a href="#api-endpoints">API Endpoints</a></li>
  <li><a href="#postman-api-testing">Postman API Testing</a></li>
  <li><a href="#how-emotion-detection-works">How Emotion Detection Works</a></li>
  <li><a href="#future-enhancements">Future Enhancements</a></li>
  <li><a href="#contributing">Contributing</a></li>
</ul>

<h2 id="installation">Installation</h2>
<ol>
  <li>Clone the repository:
    <pre><code>git clone https://github.com/Shinde-Yogesh/journalApp.git
cd journalApp</code></pre>
  </li>
  <li>Install dependencies:
    <pre><code>./mvnw clean install</code></pre>
  </li>
  <li>Run the application:
    <pre><code>./mvnw spring-boot:run</code></pre>
  </li>
</ol>

<h2 id="api-endpoints">API Endpoints</h2>
<h3>1. Create a Admin 🤵</h3>
<ul>
  <li><strong>POST</strong> <code>/admin/create-admin-user</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>{
    "userName":"John",
    "password":"John",
    "email":"john@gmail.com",
    "sentimentAnalysis":true
}</code></pre>
  </li>
  <li><strong>Response</strong>: 201 Created - Admin created successfully.</li>
</ul>

<h3>2. All User's 👨🏼‍🤝‍👨🏼</h3>
<ul>
  <li><strong>POST</strong> <code>/admin//all-users</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>
       <h4> Authorization </h4>
      {
      "Username" : "John"
      "Password" : "John"
}</code></pre>
  </li>
  <li><strong>Response</strong>: 200 Created - successfully.</li>
</ul>

<h3>1. Create a User 🤵</h3>
<ul>
  <li><strong>POST</strong> <code>/public/create-user</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>{
    "userName":"Karl",
    "password":"Karl",
    "email":"karl@gmail.com",
    "sentimentAnalysis":true
}</code></pre>
  </li>
  <li><strong>Response</strong>: 201 Created - User created successfully.</li>
</ul>

<h3>2. Update User ✍️</h3>
<ul>
  <li><strong>PUT</strong> <code>/user</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>{
    "userName":"Thomas",
    "password":"Thomas",
    "email":"thomas@gmail.com",
    "sentimentAnalysis":false
}
      <h4>Authorization</h4>
      "Username" : "Karl"
      "Password" : "Karl
    </code></pre>
  </li>
  <li><strong>Response</strong>: 200 OK - User updated.</li>
</ul>

<h3>3. Delete a User 🗑️</h3>
<ul>
  <li><strong>DELETE</strong> <code>/user</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>{
    "userName":"Karl",
    "password":"Karl",
}</code></pre>
  </li>
  <li><strong>Response</strong>: 204 No Content - User deleted.</li>
</ul>

<li><strong>Response</strong>
  <h3> For Every Journal Entry username and password needed </h3>
     <pre><code>
      <h4>Authorization</h4>
      "Username" : "Karl"
      "Password" : "Karl"
    </code></pre>
</li>
<h3>1. Create a Journal Entry 📝</h3>
<ul>
  <li><strong>POST</strong> <code>/api/journals</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>{
    "title":"journalist",
    "content":"cleark job in city",
    "sentiment":"SAD"
}
    </code></pre>
  </li>
  <li><strong>Response</strong>: 201 Created - Journal entry created successfully.</li>
</ul>

<p>Click <strong>Here</strong> to see the response.</p>
![image](https://github.com/user-attachments/assets/2e54580b-a12c-41f6-8cb7-45edd0f8ecd5)

<h3>2. Update a Journal Entry ✍️</h3>
<ul>
  <li><strong>PUT</strong> <code>/journal/id/{id}</code></li>
  <li><strong>Request Body</strong>:
    <pre><code>{
    "title":"photographer",
    "content":"cleark job in city",
    "sentiment":"HAAPY"
}
    </code></pre>
  </li>
  <li><strong>Response</strong>: 201 OK - Journal entry updated.</li>
</ul>

<h3>3. Delete a Journal Entry 🗑️</h3>
<ul>
  <li><strong>DELETE</strong> <code>/journal/id/{id}</code></li>
  <li><strong>Request Body</strong>:
  </li>
   <li><strong>Response</strong>: 204 No Content - Journal entry deleted.</li>
</ul>

<h3>4. Get Journal Entries 📖</h3>
<ul>
  <li><strong>GET</strong> <code>/api/journals</code></li>
  <li><strong>Response</strong>: 200 OK - Returns a list of journal entries.</li>
</ul>
<h2 id="how-emotion-detection-works">How Emotion Detection Works</h2>

<ol>
  <li>The system analyzes the content of journal entries using <strong>NLP techniques</strong>.</li>
  <li>It computes the emotional tone based on the last 7 days of entries.</li>
  <li>A personalized email is sent based on the user's emotional state:
    <ul>
      <li>😊 Happy: Positive email.</li>
      <li>😔 Sad: Encouraging email.</li>
      <li>😡 Angry: Calming message.</li>
    </ul>
    <p>Click <strong>Here</strong> to see the response.</p>
![image](https://github.com/user-attachments/assets/f6796efc-1c60-436f-aab3-7741e89e24cb)

  </li>
</ol>

<h2 id="future-enhancements">Future Enhancements</h2>
<ul>
  <li>Integration with external APIs for improved emotion analysis.</li>
  <li>Adding user authentication for a more personalized experience.</li>
  <li>Support for multiple languages for emotion detection.</li>
</ul>

<h2 id="contributing">Contributing</h2>
<p>Contributions are welcome! Please follow these steps:</p>
<ol>
  <li>Fork the repository.</li>
  <li>Create a new branch (<code>git checkout -b feature-branch</code>).</li>
  <li>Commit your changes (<code>git commit -m 'Add new feature'</code>).</li>
  <li>Push to the branch (<code>git push origin feature-branch</code>).</li>
  <li>Create a new Pull Request.</li>
</ol>
