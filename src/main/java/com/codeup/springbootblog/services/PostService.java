package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;


    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        // Generates a consecutive number
        post.setId(posts.size() + 1);
        this.posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)(id - 1));
    }

    private void createPosts() {
        // create some post objects and add them to the posts list
        // with the save method
        save(new Post("Day 1: EO Basics: What are essential oils?", "Oils are the life-force or life-blood of plants. The essential oil of the plant is what keeps the plant thriving. Those same chemical constituents help our bodies thrive too! Essential oils come from every part of the plant: flower, root, stem, bark, etc! All of it!\n" +
                "\n" +
                "Essential oils are VERSATILE, VOLATILE, and POTENT! Check it out...\n" +
                "\n" +
                "Versatile - Each essential oil has many different uses. For instance, Lavender is very calming and can help encourage restfulness, but it is also great for skin and hair care! I use essential oils for cleaning, skin care, fitness, first aid, immune support, relaxation, etc. etc. etc.\n" +
                "\n" +
                "Volatile - this means a substance has the ability to leap into the air or to “fly.” This is why oils are fragrant and the aroma can smelled across a room. The essential oil is reaching our bodies aromatically, even when we are not in contact with it! When the plant matter is steam distilled, the only constituents that are collected in that process are those that can travel up with the steam...that is the plant’s essential oil.\n" +
                "\n" +
                "Potent - Essential oils are very powerful! One drop contains approximately 40 million-trillion cells. That is 40,000,000,000,000,000,000! (For reference, the human body is composed of 100 trillion cells.) How is this possible? Well, essential oils are powerful, but they are also TINY! This allows them to pass through our skin into our cells to do their extraordinary therapeutic work! The powerful work of essential oils is done by their chemical constituents, phenols and terpenes. These are naturally occurring compounds that have amazing abilities to support our immune systems, cleanse our bodies at the cellular level, support a decrease of inflammation, and act as calming agents. Sesquiterpenes are a type terpene that are found in high concentrations in essential oils such as Cedarwood, Sandalwood, Myrrh and Vetiver. The National Institute of Health describes Sesquiterpenes (say that three times fast) as “a class of naturally occurring molecules that have demonstrated therapeutic potential in decreasing the progression of cancer.”\n" +
                "\n" +
                "Essential oils have been around for a looooong time. They actually have been used to support wellness for thousands of years! Here is a little bit of essential oil history: https://www.youngliving.com/blog/essential-oils-a-timeline/\n" +
                "\n" +
                "Aren’t oils neat?? What did you find most interesting from today’s information?"));
        save(new Post("Day 2: Ways to Use Essential Oils", "There are 3 ways to use essential oils: aromatically, topically, and internally.\n" +
                "\n" +
                "Using your oils topically:\n" +
                "Direct application onto the skin is one of the easiest ways to use essential oils. It is also a highly effective method since essential oils can easily pass through the lipid membranes of cell walls. They are able to penetrate cells and disperse throughout the body within minutes. The bottom of the feet is a good place to apply oils directly because many nerve endings are found there and the pores of the skin are large in that area. (Cool, right?)\n" +
                "\n" +
                "Before you start, remember to test a small area of the skin. Apply one oil or blend at a time. When layering oils that are new to you, allow 15-30 minutes between each oil to give the body a chance to respond before applying a second oil. The longer essential oils stay in contact with the skin, the more likely they are to be absorbed. To reduce evaporation and enhance penetration, putting socks on after applying can help.\n" +
                "Carrier oils extend essential oils when they are applied to a large area, and can decrease skin irritation as well. When applying essential oils to children, always use a carrier oil. Examples of common carrier oils include coconut oil, grapeseed oil, vitamin e oil, sweet almond oil, & olive oil.\n" +
                "….\n" +
                "Using your oils aromatically:\n" +
                "Diffusing essential oils is a perfect way to improve your home, work, or living environment. In fact, it’s probably my favorite way to use oils!\n" +
                "Diffusing can purify the air and neutralize mildew, cigarette smoke or other odors as well as protect you and your family from harmful things we breathe in the air. Diffusing can also help with mood regulation.\n" +
                "To inhale essential oils, try the following:\n" +
                "· Place 2 drops into the palm of your hand; Cup hands together over the nose and mouth and inhale deeply.\n" +
                "· Add several drops of an essential oil to a bowl of hot (not boiling) water. Inhale the vapors that rise from the bowl. A towel can be placed over the head and bowl to increase the intensity of the vapors.\n" +
                "· Apply a few drops of essential oil to a cotton ball, tissue, natural-fiber handkerchief, or clay necklace and inhale periodically.\n" +
                "There are so many options with this one! Huff yourself silly!\n" +
                "….\n" +
                "Using your oils for dietary/internally:\n" +
                "This is totally optional of course. In fact, it may seem like a new idea to ingest essential oils, but there are actually thousands of food products that currently use essential oils for aroma and flavor. For example, chewing gum, chocolates, candies, etc.The FDA (Food and Drug Administration) classifies certain essential oils as GRAS (generally recognized as safe).\n" +
                "\n" +
                "But if you study aromatherapy, you'll see that people have ingested oils for thousands of years for all sorts of health benefits.\n" +
                "\n" +
                "We add oils to beverages to support immunity, flavor water or other beverages, or even add to our cooking and baking.\n" +
                "\n" +
                "Young Living has an entire line of dietary oils called VITALITY, and the most popular ones are included in the Premium Starter Kit."));
        save(new Post("Day 3: Why did we choose Young Living?", "After doing a LOT of research on oils of all different brands, we made the confident decision to go with Young Living.\n" +
                "\n" +
                "This is hands-down one of those cases where you get what you pay for. Yes, you *can* buy a cheaper bottle of oil elsewhere, but *buyer beware* you are receiving an inferior product.\n" +
                "\n" +
                "Young Living is the only company out there that has what is called the “Seed to Seal” promise, or anything like it. This has such a huge impact, you guys! It means that Young Living controls every single aspect of their production line. They oversee it all and have rigorous testing and quality control standards! SO that’s a big deal for me.\n" +
                "\n" +
                "They own their own farms. Another cool thing is that you can actually GO TO THEIR FARMS. They let you see the Seed to Seal in action! How cool is that?\n" +
                "\n" +
                "They plant their own seeds.\n" +
                "They cultivate their own crops.\n" +
                "They use essential oils on their plants, never pesticides or anything like that!\n" +
                "They oversee everything, literally, from planting the seed to sealing the bottle. They can say with a 100% guarantee that they know what is inside each and every bottle, and that they are pure beyond a shadow of a doubt.\n" +
                "In our house, we have been working on living as chemical and additive free as possible.\n" +
                "This. This is why I chose Young Living. Rest assured that this is the best company out there.\n" +
                "\n" +
                "The skin is the largest organ in the body, and if I’m going to be consistently using these products on the skin of myself and my loved ones (and breathing them in, and ingesting them), I want to know exactly what I’m getting. YL gives me that peace of mind. And you want to know that you’re giving your family the best.\n" +
                "\n" +
                "Take a look at this video all about the Seed to Seal process. http://seedtoseal.com/en\n" +
                "\n" +
                "**Question of the day** What do you find most interesting about our Seed to Seal process?"));
        save(new Post("this is the title", "this is the body"));
    }

    public void update(Post post) {
        posts.set((int)post.getId() -1, post);
    }
}
