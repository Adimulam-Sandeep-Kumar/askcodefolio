package com.sandeep.portfolio.controller;

import com.sandeep.portfolio.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "coder") String theme) {
        model.addAttribute("theme", theme);
        model.addAttribute("currentTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        model.addAttribute("developer", getDeveloperInfo());
        model.addAttribute("skills", getSkills());
        model.addAttribute("projects", getProjects());
        model.addAttribute("achievements", getAchievements());
        model.addAttribute("timeline", getTimeline());
        return "index";
    }

    @GetMapping("/terminal")
    public String terminal(@RequestParam(defaultValue = "") String command, Model model) {
        model.addAttribute("command", command);
        model.addAttribute("output", processCommand(command));
        model.addAttribute("developer", getDeveloperInfo());
        return "terminal";
    }

    @PostMapping("/terminal")
    public String processTerminal(@RequestParam String command, Model model) {
        return "redirect:/terminal?command=" + command;
    }

//    private Developer getDeveloperInfo() {
//        return Developer.builder()
//                .name("Adimulam Sandeep Kumar")
//                .title("Java Backend Developer")
//                .email("sandeepkumaradimulam@gmail.com")
//                .phone("8247062293")
//                .linkedin("linkedin.com/in/adimulam-sandeep-kumar-586231207")
//                .location("India")
//                .status("ONLINE")
//                .build();
//    }

    private Developer getDeveloperInfo() {
        Developer developer = new Developer();
        developer.setName("Adimulam Sandeep Kumar");
        developer.setTitle("Java Backend Developer");
        developer.setEmail("sandeepkumaradimulam@gmail.com");
        developer.setPhone("8247062293");
        developer.setLinkedin("linkedin.com/in/adimulam-sandeep-kumar-586231207");
        developer.setLocation("India");
        developer.setStatus("ONLINE");
        return developer;
    }

//    private List<Skill> getSkills() {
//        return Arrays.asList(
//            new Skill("Core Java", "PROGRAMMING LANGUAGE", 90, "☕"),
//            new Skill("Spring Boot", "FRAMEWORK", 90, "🍃"),
//            new Skill("MySQL", "DATABASE", 90, "💄"),
//            new Skill("MongoDB", "NOSQL", 90, "🍃"),
//            new Skill("RabbitMQ", "MESSAGING", 90, "🐰"),
//            new Skill("Redis", "CACHE", 90, "⚡"),
//            new Skill("Docker", "CONTAINER", 90, "🐳"),
//            new Skill("GitHub", "VERSION CONTROL", 90, "🐙"),
//            new Skill("Bitbucket", "VERSION CONTROL", 90, "🪰"),
//            new Skill("JIRA", "PROJECT MANAGEMENT", 90, "📌"),
//            new Skill("Confluence", "DOCUMENTATION", 90, "📓"),
//            new Skill("AWS", "CLOUD", 90, "☁️"),
//            new Skill("GCP", "CLOUD", 90, "🌩️"),
//            new Skill("Swagger", "API TOOL", 90, "📘"),
//            new Skill("Postman", "API TOOL", 90, "📬")
//        );
//    }

    private List<Skill> getSkills() {
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Core Java", "PROGRAMMING LANGUAGE", 90, "☕"));
        skills.add(new Skill("Spring Boot", "FRAMEWORK", 90, "🍃"));
        skills.add(new Skill("MySQL", "DATABASE", 90, "💄"));
        skills.add(new Skill("MongoDB", "NOSQL", 90, "🍃"));
        skills.add(new Skill("RabbitMQ", "MESSAGING", 90, "🐰"));
        skills.add(new Skill("Redis", "CACHE", 90, "⚡"));
        skills.add(new Skill("Docker", "CONTAINER", 90, "🐳"));
        skills.add(new Skill("GitHub", "VERSION CONTROL", 90, "🐙"));
        skills.add(new Skill("Bitbucket", "VERSION CONTROL", 90, "🪰"));
        skills.add(new Skill("JIRA", "PROJECT MANAGEMENT", 90, "📌"));
        skills.add(new Skill("Confluence", "DOCUMENTATION", 90, "📓"));
        skills.add(new Skill("AWS", "CLOUD", 90, "☁️"));
        skills.add(new Skill("GCP", "CLOUD", 90, "🌩️"));
        skills.add(new Skill("Swagger", "API TOOL", 90, "📘"));
        skills.add(new Skill("Postman", "API TOOL", 90, "📬"));
        return skills;
    }

//    private List<Project> getProjects() {
//        return Arrays.asList(
//            Project.builder()
//                .name("Scalable Job Feed Processor")
//                .description("Processed 1.6 million job records in 20 minutes by optimizing data extraction and filtering logic.")
//                .performance("1.6M records / 20 min")
//                .build(),
//
//            Project.builder()
//                .name("Intelligent Job Description Generator")
//                .description("Leveraged external APIs to generate 60 unique descriptions per job posting, producing 19,200 entries per hour and increasing revenue by 33.33%.")
//                .performance("19.2K descriptions/hour, +33.33% revenue")
//                .build(),
//
//            Project.builder()
//                .name("Backend Quality & Integration Suite")
//                .description("Reduced post-release issues by 20% through clean code practices and bug diagnosis; implemented RESTful APIs, documented via Confluence, and improved team collaboration by 57%.")
//                .performance("20% fewer issues, 57% team efficiency gain")
//                .build()
//        );
//    }

    private List<Project> getProjects() {
        return Arrays.asList(
            new Project(
                "Scalable Job Feed Processor",
                "Processed 1.6 million job records in 20 minutes by optimizing data extraction and filtering logic.",
                "1.6M records / 20 min"
            ),
            new Project(
                "Intelligent Job Description Generator",
                "Leveraged external APIs to generate 60 unique descriptions per job posting, producing 19,200 entries per hour and increasing revenue by 33.33%.",
                "19.2K descriptions/hour, +33.33% revenue"
            ),
            new Project(
                "Backend Quality & Integration Suite",
                "Reduced post-release issues by 20% through clean code practices and bug diagnosis; implemented RESTful APIs, documented via Confluence, and improved team collaboration by 57%.",
                "20% fewer issues, 57% team efficiency gain"
            )
        );
    }

    private List<Achievement> getAchievements() {
        return Arrays.asList(
                new Achievement("🚀", "Processed 1.6M job entries in 20 mins", "PERFORMANCE"),
                new Achievement("⚡", "Reduced post-release issues by 20%", "QUALITY"),
                new Achievement("🎯", "Boosted API response by 33.3%", "OPTIMIZATION"),
                new Achievement("🏗️", "Built scalable microservices architecture", "ARCHITECTURE"),
                new Achievement("🔧", "Implemented real-time messaging systems", "INTEGRATION")
        );
    }

    private List<TimelineEvent> getTimeline() {
        return Arrays.asList(
            new TimelineEvent("2025", "Senior Software Engineer", "FirstMeridian Business Services Limited — Leading scalable backend projects", "CURRENT"),
            new TimelineEvent("2024", "Freelance Java Developer", "TriWish Systems Private Limited — Delivered multiple microservice-based backend projects", "COMPLETED"),
            new TimelineEvent("2022–2024", "Java Developer", "Jobiak Software Pvt Ltd — Developed APIs and integrated services", "COMPLETED"),
            new TimelineEvent("2022", "MCA", "Vignan's Institute of Information Technology (VIIT)", "COMPLETED")
        );
    }

    private String processCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return  "┌─────────────────────────────────────────────┐\n" +
                    "│ Welcome to Sandeep's Backend Dev Terminal 🖥️ │\n" +
                    "└─────────────────────────────────────────────┘\n" +
                    "Type './help' to see available commands.";
        }

        switch (command.toLowerCase().trim()) {
            case "./help":
                return  "📜 Available Commands:\n" +
                        "├── ./show-skills     → Display technical skills\n" +
                        "├── ./projects list   → Show project portfolio\n" +
                        "├── ./contact --me    → Get contact information\n" +
                        "├── ./achievements    → View key accomplishments\n" +
                        "└── ./clear           → Clear the terminal";

            case "./show-skills":
                return  "🔧 BACKEND SKILLS LOADED\n" +
                        "├── ☕ Core Java\n" +
                        "├── 🍃 Spring Boot\n" +
                        "├── 📘 Swagger\n" +
                        "├── 📬 Postman\n" +
                        "├── 💄 MySQL\n" +
                        "├── 🍃 MongoDB\n" +
                        "├── 🐰 RabbitMQ\n" +
                        "├── ⚡ Redis\n" +
                        "├── 🐳 Docker\n" +
                        "├── 🐙 GitHub\n" +
                        "├── 🪰 Bitbucket\n" +
                        "├── 📌 JIRA\n" +
                        "├── 📓 Confluence\n" +
                        "├── ☁️ AWS\n" +
                        "└── 🌩️ GCP\n" +
                        "\n👉 Type './projects list' to explore backend solutions";

            case "./projects list":
                return  "📁 PROJECT REPOSITORY\n" +
                        "├── Scalable Job Feed Processor\n" +
                        "│   ↪ Processed 1.6M records in 20 minutes\n" +
                        "├── Intelligent JD Generator\n" +
                        "│   ↪ 19.2K job descriptions/hour\n" +
                        "│   ↪ Boosted revenue by 33.3%\n" +
                        "└── Backend Quality & Integration Suite\n" +
                        "│   ↪ Reduced post-release issues by 20%\n" +
                        "│   ↪ Improved engineering efficiency by 57%\n";
                
            case "./contact --me":
                return  "📇 DEVELOPER CONTACT\n" +
                        "├── 📧 sandeepkumaradimulam@gmail.com\n" +
                        "├── 📱 8247062293\n" +
                        "├── 🔗 linkedin.com/in/adimulam-sandeep-kumar-586231207\n" +
                        "├── 🌍 India\n" +
                        "└── ⚡  AVAILABLE FOR OPPORTUNITIES";

            case "./status":
                return  "💻 SYSTEM STATUS\n" +
                        "├── 🟢 Backend Services : ONLINE\n" +
                        "├── 🟢 API Gateway      : OPERATIONAL\n" +
                        "├── 🟢 Database         : CONNECTED\n" +
                        "├── 🟢 Cache Layer      : ACTIVE\n" +
                        "├── 🟢 Message Queue    : PROCESSING\n" +
                        "└── ⚡  Uptime           : 99.9%";

            case "./achievements":
                return  "🏆 ACHIEVEMENTS\n" +
                        "├── 🚀 Performance Master   : 1.6M records processed\n" +
                        "├── ⚡  Speed Demon          : 33.3% API optimization\n" +
                        "├── 🛡️ Quality Guardian     : 20% issue reduction\n" +
                        "├── 🏗️ Architecture Wizard  : Microservices expertise\n" +
                        "└── 🔧 Integration Ninja    : Real-time systems";

            case "./clear":
                return "";

            default:
                return "❌ Unknown command: `" + command + "`\nType './help' to view available options.";
        }
    }
}
