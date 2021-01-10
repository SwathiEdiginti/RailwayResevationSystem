import java.io.*;

    public class railreserve

    {

    InputStreamReader isr=new InputStreamReader (System.in);

    BufferedReader br=new BufferedReader (isr);

    //System.out.println("Please enter a word"

    //   );

    int pno[]=new int[275];

    String name[]=new String[275];

    String phno[]=new String[275];
    int age[]=new int[275];

    int cl[]=new int[275];

    int pcount=0;
    int pnum=1;

    int max1=75;

    int max2=125;

    int max3=175;

    public static void main(String args[])

    {

    public void doMenu()throws Exception

    {

    int cho=0;

    do
{

    System.out.println("\f");

    doHeading();

    System.out.println("1.Book ticket");

    System.out.println("2.Cancel ticket");
    System.out.println("3.Search passenger");

    System.out.println("4.Reservation chart");

    System.out.println("5.Display unbooked tickets");

    System.out.println("6.Exit");

    System.out.println("Please enter your choice");

    cho=Integer.parseInt(br.readLine());

    switch(cho)

    {

    case 1:doBook();

    break;

    case 2:doCancel();

    break;

    case 3:doSearch();

    break;

    case 4:doDispList();

    break;

    case 5:doDispUnbooked();

    break;

    case 6:doExit();

    break;

    default :System.out.println("Invalid choice");

    }

    char e=(char)br.read();

    }while(cho!=6);

    }

    private void doHeading()throws Exception

    {

    System.out.println("#########################################################");

    System.out.println("*********Railway Reservation For Kabul Express***********");

    System.out.println("#########################################################");

    }

    private void doBook()throws Exception

    {

    System.out.println("Please enter the class of ticket");
063
    System.out.println("1. AC\t 2. First\t 3. Sleeper\t");
064
    int c=Integer.parseInt(br.readLine());
065
    System.out.println("Please enter no. of tickets");
066
    int t=Integer.parseInt(br.readLine());
067
    int ticketAvailable=0;
068
    if(c==1 && max1>=t)
069
    {
070
    ticketAvailable=1;
071
    }
072
    if(c==2 && max2>=t)
073
    {
074
    ticketAvailable=1;
075
    }
076
    if(c==3 && max3>=t)
077
    {
078
    ticketAvailable=1;
079
    }
080
    if(ticketAvailable==1)
081
    {
082
    for(int i=0;i<t;i++)
083
    {
084
    pno[pcount]=pnum;
085
    System.out.println("Please enter your name");
086
    name[pcount]=br.readLine();
087
    System.out.println("Please enter your age");
088
    age[pcount]=Integer.parseInt(br.readLine());
089
    cl[pcount]=c;
090
    System.out.println("Please enter your phno");
091
    phno[pcount]=br.readLine();
092
    pcount++;
093
    pnum++;
094
    System.out.println("Ticket successfully booked");
095
    }//for
096
    if(c==1)
097
    {
098
    max1-=t;
099
    System.out.println("Please pay Rs."+t*1500);
100
    }
101
    if(c==2)
102
    {
103
    max2-=t;
104
    System.out.println("Please pay Rs."+t*1200);
105
    }
106
    if(c==3)
107
    {
108
    max3-=t;
109
    System.out.println("Please pay Rs."+t*1000);
110
    }
111
    }
112
    }
113
    private void doCancel()throws Exception
114
    {
115
    int t_pno[]=new int[275];
116
    String t_name[]=new String[275];
117
    String t_phno[]=new String[275];
118
    int t_age[]=new int[275];
119
    int t_cl[]=new int[275];
120
    int t_pcount=0;
121
    int passengerFound=0;
122
    System.out.println("Please enter your passenger no.");
123
    int p=Integer.parseInt(br.readLine());
124
    for(int i=0;i<pcount;i++)
125
    {
126
    if(pno[i]!=p)
127
    {//transfer
128
    t_pno[t_pcount]=pno[i];
129
    t_name[t_pcount]=name[i];
130
    t_phno[t_pcount]=phno[i];
131
    t_age[t_pcount]=age[i];
132
    t_cl[t_pcount]=cl[i];
133
    t_pcount++;
134
    }
135
    else
136
    {
137
    passengerFound=1;
138
    if(cl[i]==1)
139
    {
140
    max1++;
141
    System.out.println("Please collect refund of Rs."+1800);
142
    }
143
    if(cl[i]==2)
144
    {
145
    max2++;
146
    System.out.println("Please collect refund of Rs."+1500);
147
    }
148
    if(cl[i]==3)
149
    {
150
    max3++;
151
    System.out.println("Please collect refund of Rs."+1000);
152
    }//else
153
    }//if
154
    }
155
    if(passengerFound==1)
156
    {
157
    pno=t_pno;
158
    name=t_name;
159
    age=t_age;
160
    cl=t_cl;
161
    phno=t_phno;
162
    pcount=t_pcount;
163
    System.out.println("ticket successfully cancelled");
164
    }
165
    }//method
166
    private void doDispList()throws Exception
167
    {
168
    System.out.println("Passenger list in AC class");
169
    System.out.println("pno \t name \t\t age \t phno");
170
    for(int i=0;i<pcount;i++)
171
    {
172
    if(cl[i]==1)
173
    {
174
    System.out.println(pno[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
175
    }
176
    }
177
    System.out.println("Passenger list in First class");
178
    System.out.println("pno \t name \t\t age \t phno");
179
    for(int i=0;i<pcount;i++)
180
    {
181
    if(cl[i]==2)
182
    {
183
    System.out.println(pno[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
184
    }
185
    }
186
    System.out.println("Passenger list in Sleeper class");
187
    System.out.println("pno \t name \t\t age \t phno");
188
    for(int i=0;i<pcount;i++)
189
    {
190
    if(cl[i]==3)
191
    {
192
    System.out.println(pno[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
193
    }
194
    }
195
    }
196
    private void doSearch()throws Exception
197
    {
198
    int passengerFound=0;
199
    System.out.println("Please enter passenger no. to search");
200
    int p=Integer.parseInt(br.readLine());
201
    for(int i=0;i<pcount;i++)
202
    {
203
    if(pno[i]==p)
204
    {
205
    System.out.println("Detail found");
206
    passengerFound=1;
207
    System.out.println("passenger no.="+pno[i]);
208
    System.out.println("name="+name[i]);
209
    System.out.println("class="+cl[i]);
210
    System.out.println("phno="+phno[i]);
211
    System.out.println("age="+age[i]);
212
    }
213
    }//for
214
    if(passengerFound==0)
215
    System.out.println("No such passenger");
216
    }//method
217
    private void doDispUnbooked()throws Exception
218
    {
219
    System.out.println("No. of booked tickets status");
220
    System.out.println("AC class"+max1);
221
    System.out.println("First class"+max2);
222
    System.out.println("Sleeper class"+max3);
223
    }
224
    private void doExit()
225
    {
226
    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
227
    System.out.println("Name : saran , Class : IT, Roll No. : 13");
228
    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
229
    };
230
    }
231
    }
